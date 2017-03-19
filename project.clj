(defproject
  org.clojars.saicheong/valip "0.4.0-SNAPSHOT"
  :description "Functional validation library for Clojure and ClojureScript.
                Forked from https://github.com/cemerick/valip"
  :url "http://github.com/saicheong/valip"
  :repositories
  [["clojars" {:url "https://clojars.org/repo/"}]
   ["maven-central" {:url "https://repo1.maven.org/maven2"}]]
  :dependencies
  [[org.clojure/clojure "1.7.0" :scope "provided"]
   [adzerk/boot-test "1.1.0" :scope "test"]
   [org.clojure/clojurescript "1.7.228" :scope "provided"]
   [adzerk/boot-cljs "1.7.170-3" :scope "test"]
   [crisptrutski/boot-cljs-test "0.2.1" :scope "test"]
   [adzerk/bootlaces "0.1.13" :scope "test"]
   [clj-time "0.13.0"]
   [com.andrewmcveigh/cljs-time "0.4.0"]]
  :clean-targets ^{:protect false} ["resources" "dev-resources" :target-path]
  :source-paths
  ["src"]
  :resource-paths
  ["src"])