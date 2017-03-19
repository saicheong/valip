# Valip

Valip is a validation library for Clojure. It is primarily designed to validate
keyword-string maps, such as one might get from a HTML form.

This is a fork of [Chas Emerick](http://github.com/cemerick)'s
[valip](http://github.com/cemerick/valip) library which, in turn, was a
fork of [James Reeves's valip](http://github.com/weavejester/valip) library.

It come from following the step by step instruction on [Mimmo Cosenza](http://github.com/magomimmo)'s
[tutorial](http://github.com/magomimmo/modern-cljs/blob/master/doc/second-edition/tutorial-19.md)
on migration of CLJ/CLJS portable libraries to use CLJ/CLJS Reader Conditional extension.
I'm using this fork to learn CLJ/CLJS and experience some of the activities around
open source contribution.

# Installation

Add the following dependency to your `project.clj` file or to your `build.boot` file:

    [org.clojars.saicheong/valip "0.4.0-SNAPSHOT"]

# Usage

The main validation function is `valip.core/validate`. It uses the following
syntax:

    (validate map-of-values
      [key1 predicate1 error1]
      [key2 predicate2 error2]
      ...
      [keyn predicaten errorn])

For each vector, the key is used to look up a value in the map. The map value
is then tested with the predicate function. If the predicate fails, the error
message is included in the map of errors returned by the `validate` function. A
key may be tested multiple times with different predicates and errors.

If no predicate fails, `nil` is returned. If at least one predicate fails, a
map of keys to errors is returned:

    {key1 [error1]
     key2 [error2]
     ...
     keyn [errorn]}

The errors are listed in a vector, because there may be multiple errors for the
same key.

For example:

    (use 'valip.core 'valip.predicates)

    (def user
      {:name "Alice", :age 7})

    (validate user
      [:name present? "must be present"]
      [:age present? "must be present"]
      [:age (over 18) "must be over 18"])

    => {:age ["must be over 18"])

You can see an example of usage of the valip library in a sample [Hoplon](http://hoplon.io/) input form
[here](http://github.com/saicheong/hoplon-input).


# Predicates

Valip has a number of useful predicates and functions that generate predicates.
More of these useful predicates will be added as the library matures.

You can find portable predicates in the `valip.predicates` namespace.
Platform-specifc predicates can be found in `valip.java.predicates` and
`valip.js.predicates`, depending on your deployment target.

## License

Copyright © 2012-2017 James Reeves and Chas Emerick

Distributed under the Eclipse Public License, the same as Clojure.
