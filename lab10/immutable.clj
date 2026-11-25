(ns immutable)

;; 1. LIST OPERATIONS
(println "===== LIST OPERATIONS =====")

(def original-list '(10 20 30 40))

(println "Original List:" original-list)
(println "First Element:" (first original-list))
(println "Rest of List:" (rest original-list))

(def new-list (conj original-list 5))

(println "After conj:" new-list)
(println "Original List (unchanged):" original-list)


;; 2. VECTOR OPERATIONS
(println "\n===== VECTOR OPERATIONS =====")

(def original-vector [10 20 30 40])

(println "Original Vector:" original-vector)
(println "Element at Index 2:" (get original-vector 2))
(println "Count:" (count original-vector))

(def new-vector (conj original-vector 50))

(println "After conj:" new-vector)
(println "Original Vector (unchanged):" original-vector)


;; 3. MAP OPERATIONS
(println "\n===== MAP OPERATIONS =====")

(def original-map {:name "Rahul"
                   :age 21
                   :course "Clojure"})

(println "Original Map:" original-map)
(println "Get Name:" (get original-map :name))

(def updated-map (assoc original-map :age 22))

(println "After assoc:" updated-map)
(println "Original Map (unchanged):" original-map)

(def new-map (dissoc original-map :course))

(println "After dissoc:" new-map)
(println "Original Map (unchanged):" original-map)


;; 4. SET OPERATIONS
(println "\n===== SET OPERATIONS =====")

(def original-set #{10 20 30 40})

(println "Original Set:" original-set)
(println "Contains 20:" (contains? original-set 20))

(def added-set (conj original-set 50))

(println "After conj:" added-set)
(println "Original Set (unchanged):" original-set)

(def removed-set (disj original-set 20))

(println "After disj:" removed-set)
(println "Original Set (unchanged):" original-set)
