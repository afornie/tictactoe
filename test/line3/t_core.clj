(ns line3.t_core
  (:use midje.sweet)
  (:require [line3.core :refer :all]
            [clojure.test :refer :all]))


(deftest cloverage-wrapper
  (fact "New side"
    (newSide :O) => :X
    (newSide :X) => :O
    )

  (fact "Get value at coords"
    (getValue [[:E :E :E]
               [:E :X :E]
               [:E :E :E]]
               {:x 1 :y 1}) => :X

    (getValue [[:X :E :E]
               [:E :E :E]
               [:E :E :E]]
               {:x 0 :y 0}) => :X

    (getValue [[:E :E :E]
               [:E :E :E]
               [:E :E :X]]
               {:x 2 :y 2}) => :X

    (getValue [[:E :E :E]
               [:E :E :X]
               [:E :E :E]]
               {:x 1 :y 2}) => :X

    (getValue [[:E :E :X]
               [:E :E :E]
               [:E :E :E]]
               {:x 0 :y 2}) => :X

    (getValue [[:E :E :E]
               [:E :E :E]
               [:X :E :E]]
               {:x 2 :y 0}) => :X
    )


  (fact "Should update the board with the given move"
    (applyMove [[:O :O :O]
                [:O :X :E]
                [:O :O :O]]
               [{:x 1 :y 1} {:x 1 :y 2}])
            => [[:O :O :O]
                [:O :E :X]
                [:O :O :O]]

    (applyMove [[:X :O :O]
                [:O :O :O]
                [:E :O :O]]
               [{:x 0 :y 0} {:x 2 :y 0}])
            => [[:E :O :O]
                [:O :O :O]
                [:X :O :O]]

    (applyMove [[:O :O :X]
                [:O :O :O]
                [:E :O :O]]
               [{:x 0 :y 2} {:x 2 :y 0}])
            => [[:O :O :E]
                [:O :O :O]
                [:X :O :O]]
  )
)
