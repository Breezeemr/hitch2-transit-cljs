(ns hitch2.transit.basic
  (:require [cognitect.transit :as t]
            [hitch2.descriptor :refer [->Descriptor Descriptor]]))


(defn make-pos-dtor [v]
  (->Descriptor (aget v 0) (aget v 1)))

(deftype ^:no-doc DTORHandler []
  Object
  (tag [_ v] "DTOR")
  (rep [_ v] (t/tagged-value "array" #js[(:name v) (:term v)]))
  (stringRep [this v] nil))



(defn reader
  ([type] (reader type {}))
  ([type opts]
    (t/reader type (update opts :handlers (fnil assoc {}) "DTOR" make-pos-dtor) )))

(defn writer
  ([type] (writer type {}))
  ([type opts]
    (t/writer type (update opts :handlers (fnil assoc {}) Descriptor  (DTORHandler.)) )))
