(ns cascalog-sandbox.core
	(:require [cascalog.api :refer :all]
	         [cascalog.ops :as ops]
	         [cascalog.more-taps :refer [hfs-delimited]]))

(defn parse-dbl [s]
   (Double. (re-find  #"^-?\d+(?:\.\d+)?$" s )))

(defn parse-number [& strings]
  (let [s strings] 
    (map parse-dbl s)))

(defn avarage-price [input]
  (<- [?code ?costs]
      (input :> ?sha ?pct ?practice ?bnf ?code ?bnf-name ?items ?nic ?act-cost ?quantity ?period)
      (parse-number ?act-cost :> ?costs)
      (ops/avg ?costs :> ?avg-costs)))

(defn -main [in out]
     (?- (hfs-delimited out :sinkmode :replace :delimiter "\t")
         (avarage-price
          (hfs-delimited in :delimiter "," :skip-header? true))))
