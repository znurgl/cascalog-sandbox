(defproject cascalog-sandbox "0.1.0-SNAPSHOT"
  :description "Example project with Cascalog and Hadoop"
  :url "https://github.com/znurgl/cascalog-sandbox"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :uberjar-name "cascalogsandbox.jar"
  :aot [cascalog-sandbox.core]
  :main cascalog-sandbox.core
  :repositories [["conjars.org" "http://conjars.org/repo"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cascalog "1.10.0"]
                 [cascalog-more-taps "0.3.1-SNAPSHOT"]
                 [org.slf4j/slf4j-api "1.7.2"]]
  :profiles {:provided
            {:dependencies
            [[org.apache.hadoop/hadoop-core "0.20.2"]]}})
