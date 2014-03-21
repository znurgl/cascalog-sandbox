(ns cascalogsandbox.core
	(:require [cascalog.api :refer :all]
           [cascalog.ops :as ops]
           [cascalog.more-taps :refer [hfs-delimited]])
 (:gen-class :main true))

;;; helper String parser function for parse-number function

(defn parse-dbl [s]
   (Double. (re-find  #"^-?\d+(?:\.\d+)?$" s )))

;;; create a Double from a string, like "00000028.12" will be 28.12

(defn parse-number [& strings]
  (let [s strings] 
    (map parse-dbl s)))

;;; create a stream with medicine name, avarage price, minimum price and maximum price

(defn price-calc [input]
  (<- [?code ?avg-costs ?min-costs ?max-costs]
      (input :> ?sha ?pct ?practice ?bnf ?code ?bnf-name ?items ?nic ?act-cost ?quantity ?period)
      (parse-number ?act-cost :> ?costs)
      (ops/avg ?costs :> ?avg-costs)
      (ops/min ?costs :> ?min-costs)
      (ops/max ?costs :> ?max-costs)))

;;; in: data file
;;; out: output folder

(defn -main [in out]
     (?- (hfs-delimited out :sinkmode :replace :delimiter "\t")
         (price-calc
          (hfs-delimited in :delimiter "," :skip-header? true))))
