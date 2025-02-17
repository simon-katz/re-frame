(defproject todomvc-re-frame "0.11.0-rc2-SNAPSHOT"
  :dependencies [[org.clojure/clojure        "1.10.1"]
                 [org.clojure/clojurescript  "1.10.520"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.8.59"]
                 [reagent "0.9.0-rc1"]
                 [re-frame "0.11.0-rc2-SNAPSHOT"]
                 [binaryage/devtools "0.9.10"]
                 [clj-commons/secretary "1.2.4"]
                 [day8.re-frame/tracing "0.5.3"]]

  :plugins [[lein-shadow "0.1.6"]]

  :clean-targets ^{:protect false} [:target-path
                                    "shadow-cljs.edn"
                                    "package.json"
                                    "package-lock.json"
                                    "resources/public/js"]

  :shadow-cljs {:nrepl {:port 8777}

                :builds {:client {:target :browser
                                  :output-dir "resources/public/js"
                                  :modules {:client {:init-fn todomvc.core/main}}
                                  :devtools {:http-root "resources/public"
                                             :http-port 8280}}}}

  :aliases {"dev-auto" ["shadow" "watch" "client"]})
