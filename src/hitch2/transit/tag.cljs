(ns hitch2.transit.tag
  (:require [cognitect.transit :as t]
            [hitch2.descriptor :refer [->Descriptor Descriptor]]))

;only supported on the latest transit-cljs
(deftype ^:no-doc DTORHandler []
  Object
  (tag [_ v] (str (:name v)))
  (rep [_ v] (:term v))
  (stringRep [this v] nil))

(defn reader
  ([type] (reader type {}))
  ([type opts]
   (t/reader type (assoc opts :default ->Descriptor))))

(defn writer
  ([type] (writer type {}))
  ([type opts]
   (t/writer type (update opts :handlers (fnil assoc {}) Descriptor DTORHandler))))

