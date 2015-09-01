(ns line3.t_board
  (:use midje.sweet)
  (:require [line3.board :refer :all]))

(fact "Check vertical"
  (checkVertical [[:X :X :X]
                  [:O :O :O]
                  [:E :E :E]] :X) => false
  (checkVertical [[:X :X :X]
                  [:O :O :O]
                  [:E :E :E]] :X) => false
  (checkVertical [[:X :X :X]
                  [:O :O :O]
                  [:E :E :E]] :X) => false
  (checkVertical [[:X :X :X]
                  [:O :O :O]
                  [:E :E :E]] :O) => false
  (checkVertical [[:X :O :X]
                  [:X :O :O]
                  [:X :E :E]] :X) => true

  (checkVertical [[:X :X :X]
                  [:O :X :O]
                  [:O :X :E]] :X) => true

  (checkVertical [[:E :O :X]
                  [:X :O :X]
                  [:E :E :X]] :X) => true
  )

(fact "Check horizontal"
  (checkHorizontal [[:O :X :X]
                    [:O :O :O]
                    [:E :E :E]] :X) => false

  (checkHorizontal [[:X :X :X]
                    [:O :O :X]
                    [:E :E :E]] :O) => false

  (checkHorizontal [[:X :O :X]
                    [:X :O :O]
                    [:X :E :E]] :X) => false

  (checkHorizontal [[:X :X :X]
                    [:O :X :O]
                    [:O :X :E]] :X) => true

  (checkHorizontal [[:E :O :X]
                    [:O :O :O]
                    [:E :E :X]] :O) => true
  )

(fact "Check winner"
  (checkWinner [[:X :X :X]
                [:O :X :O]
                [:E :E :E]]) => :X

  (checkWinner [[:X :X :E]
                [:O :X :O]
                [:E :X :E]]) => :X

  (checkWinner [[:X :E :X]
                [:O :O :O]
                [:E :E :E]]) => :O

  (checkWinner [[:X :X :O]
                [:O :X :O]
                [:E :E :O]]) => :O

  (checkWinner [[:E :X :X]
                [:O :X :O]
                [:E :E :E]]) => nil
  )


