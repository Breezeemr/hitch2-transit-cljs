(ns hitch2.transit.basic-test
  (:require [clojure.test :refer [deftest is testing]]
            [hitch2.transit.basic :refer [reader writer]]
            [hitch2.descriptor :refer [->Descriptor]]))

(deftest basic
  (testing "roundtrip"
    (let [r (reader "json")
          w (writer "json")
          sample (->Descriptor (symbol "blah.cal") {:hi "there"})]

      (is (= (.read r (.write w sample)) sample)))))
