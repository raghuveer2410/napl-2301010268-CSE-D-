
(ns sequence-processing)

;; Function to demonstrate sequence processing
(defn process-sequence [numbers]

  (println "\nOriginal Collection:" numbers)

  ;; 1. MAP - Square each element
  (println "Squares using map:"
           (map #(* % %) numbers))

  ;; 2. FILTER - Select even numbers
  (println "Even numbers using filter:"
           (filter even? numbers))

  ;; 3. REDUCE - Calculate sum
  (println "Sum using reduce:"
           (reduce + numbers))

  ;; Calculate maximum
  (println "Maximum using reduce:"
           (reduce max numbers))

  ;; 4. TAKE - Select first 3 elements
  (println "First 3 elements using take:"
           (take 3 numbers))

  ;; DROP - Skip first 2 elements
  (println "After drop 2:"
           (drop 2 numbers))

  ;; 5. THREADING MACRO (->>)
  ;; Select even numbers, square them, and collect as a vector
  (println "Threading macro result:"
           (->> numbers
                (filter even?)
                (map #(* % %))
                (vec))))


;; TEST CASE 1 - List
(println "========== TEST CASE 1 ==========")

(def collection1 '(1 2 3 4 5 6))

(process-sequence collection1)


;; TEST CASE 2 - Vector
(println "\n========== TEST CASE 2 ==========")

(def collection2 [10 15 20 25 30 35])

(process-sequence collection2)
