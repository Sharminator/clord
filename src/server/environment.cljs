(ns server.environment
  (:require ["dotenv" :as dotenv]))

(.load dotenv)
(defn -js->clj+
      "For cases when built-in js->clj doesn't work. Source: https://stackoverflow.com/a/32583549/4839573"
      [x]
      (into {} (for [k (js-keys x)]
                    [k (aget x k)])))
(defn env
      "Returns current env vars as a Clojure map."
      []
      (-js->clj+ (.-env js/process)))

(def env-vars (env))
