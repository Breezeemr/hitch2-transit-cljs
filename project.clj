(defproject com.breezeehr/hitch2-transit-cljs "0.3.1-SNAPSHOT"
  :description ""
  :url "https://github.com/Breezeemr/hitch2/tree/master/"
  :repositories [["snapshots" {:url "s3p://breezepackages/snapshots" :creds :gpg}]
                 ["releases" {:url "s3p://breezepackages/releases" :creds :gpg}]]
  :dependencies [[org.clojure/clojurescript "1.10.339"]
                 [com.cognitect/transit-cljs "0.8.256"]
                 [com.breezeehr/hitch2 "0.3.2-SNAPSHOT"]])
