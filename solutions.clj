;; Problem 4

;; checks if the given number is palindromic.
(defn is-palindrome? [x]
  (let [
    xstr (str x)
    num (int (Math/ceil (/ (count xstr) 2)))
    f-half (drop num xstr)
    s-half (drop-last num xstr)
    ]
    (= f-half (reverse s-half))))

;; returns the largest palindromic number which is multiple of two 3 digit numbers.
(defn solution4 [] 
  (apply max (filter is-palindrome? 
    (for [x (range 100 999) y (range 100 999) :when (>= y x)] (* x y)))))

;; Problem 7

;; checks if the given number is prime.
(defn is-prime? [n]
  (or (= 2 n)
   (not-any? #(= 0 (mod n %)) (range 3 (inc (Math/sqrt n)) 2))))

;; returns nth prime number.
(defn nth-prime [n]
  (last (take n (filter #(prime? %) (cons 2 (iterate (partial + 2) 3))))))

;; returns 10001th prime number.
(defn solution7 []
  (nth-prime 10001))
