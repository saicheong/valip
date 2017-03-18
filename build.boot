(set-env!
  :source-paths #{"src"}
  :resource-paths #{"src"}

  :dependencies '[[org.clojure/clojure "1.7.0" :scope "provided"]
                  [adzerk/boot-test "1.1.0" :scope "test"]
                  [org.clojure/clojurescript "1.7.228" :scope "provided"]
                  [adzerk/boot-cljs "1.7.170-3" :scope "test"]
                  [crisptrutski/boot-cljs-test "0.2.1" :scope "test"]
                  [adzerk/bootlaces "0.1.13" :scope "test"]
                  [clj-time "0.13.0"]
                  [com.andrewmcveigh/cljs-time "0.4.0"]])

(require '[boot.lein])
(boot.lein/generate)

(require '[adzerk.boot-test :refer [test]]
         '[adzerk.boot-cljs :refer [cljs]]
         '[crisptrutski.boot-cljs-test :refer [test-cljs]]
         '[adzerk.bootlaces :refer [bootlaces! build-jar push-snapshot]])

(def +version+ "0.4.0-SNAPSHOT")
(bootlaces! +version+)

(task-options!
  push {:ensure-branch nil}
  pom {:project 'org.clojars.saicheong/valip
       :version "0.4.0-SNAPSHOT"
       :description "Functional validation library for Clojure and Clojurescript.
                     Forked from https://github.com/cemerick/valip"
       :url "http://github.com/saicheong/valip"
       :scm {:url "http://github.com/saicheong/valip"}
       :license {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}}
  test {:namespaces #{'valip.test.core 'valip.test.predicates}}
  test-cljs {:namespaces #{'valip.test.core 'valip.test.predicates}})

(deftask testing
         []
         (merge-env! :source-paths #{"test"})
         identity)

(deftask tdd
         "Launch a CLJ TDD Environment"
         []
         (comp
           (testing)
           (watch)
           (test-cljs)
           (test)))