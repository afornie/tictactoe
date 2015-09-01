(ns line3.core
  (:require [line3.board :refer :all])
  (:require [line3.prompt :refer :all]))

(defn newSide
  [currentSide]
  (if (= currentSide :O)
    :X
    :O))

(defn getValue
  [board coords]
  (nth (nth board (coords :x)) (coords :y)))

(defn boardWith
  [board {x :x y :y} side]
  (assoc board x (assoc (nth board x) y side)))

(defn applyMove
  [board [from to]]
  (boardWith (boardWith board to (getValue board from))
             from :E))

(defn playRound
  [board side]
  (let [move (promptMove)]
    (println move)
    (applyMove board move)))

(defn newRound
  [board side]
  (loop [board board
         side side]
    (printBoard board)
    (println "Turn for side " side)
    (let [board (playRound board side)]
      (println "Round played")
      (println board)
      (let [winner (checkWinner board)]
        (println "Winner is")
        (println winner)
        (if winner
          (println "Game over")
          (recur board (newSide side)))))))

(defn -main
  []
  (newRound
   [[:X :O :X][:E :E :E][:O :X :O]] :X))


