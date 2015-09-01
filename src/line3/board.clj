(ns line3.board)

(defn checkHorizontal
  ([board side]
  (if (or (checkHorizontal board side (nth board 0))
          (checkHorizontal board side (nth board 1))
          (checkHorizontal board side (nth board 2)))
    true
    false))
  ([board side row]
  (if (and (= side (nth row 0))
           (= side (nth row 1))
           (= side (nth row 2)))
    true
    false))
 )

(defn checkVertical
  ([board side]
  (if (or (checkVertical board side 0)
          (checkVertical board side 1)
          (checkVertical board side 2))
    true
    false))
  ([board side col]
  (if (and (= side (nth (nth board 0) col))
           (= side (nth (nth board 1) col))
           (= side (nth (nth board 2) col)))
    true
    false))
 )

(defn checkWinner
  ([board]
  (if (checkWinner board :X)
    :X
    (if (checkWinner board :O)
      :O
      nil)))
  ([board side]
  (if (or (checkHorizontal board side)
          (checkVertical board side))
       true
       false)))

(defn printBoard
  [board]
  (println (nth board 0))
  (println (nth board 1))
  (println (nth board 2))
  )

