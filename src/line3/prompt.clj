(ns line3.prompt)

(defn promptX []
  (println "X coord? ")
  (read-string (read-line)))

(defn promptY []
  (println "Y coord? ")
  (read-string (read-line)))

(defn promptCoords
  []
  (let [x (promptX)
        y (promptY)]
        {:x x :y y}))

(defn promptOrigin
  []
  (println "Define next move from")
  (promptCoords))

(defn promptDestination
  []
  (println "Define next move destination")
  (promptCoords))

(defn promptMove
  []
  [(promptOrigin) (promptDestination)])

