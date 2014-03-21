(ns cascalogsandbox.core-test
  (:require [clojure.test :refer :all]
            [cascalogsandbox.core :refer :all]))

(deftest parse-number-test
  (testing "Testing to create doubles from strings"
    (is (= [1.0 2.0 28.2323] (parse-number "000001.00" "0002" "00000028.2323")))))