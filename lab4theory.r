library(datasets)

data(iris)

set.seed(99)

kmeans_result <- kmeans(iris[, 1:4], centers = 3, nstart = 20)

print(kmeans_result)

plot(iris[, c("Sepal.Width", "Petal.Width")], 
     col = kmeans_result$cluster,
     main = "Cluster Plot", 
     xlab = "Sepal.Width", 
     ylab = "Petal.Width")

plot(iris[, c("Petal.Length", "Petal.Length")], 
     col = kmeans_result$cluster,
     main = "Cluster Plot", 
     xlab = "Petal.Length", 
     ylab = "Petal.Length")

plot(iris[, c("Petal.Width", "Sepal.Length")], 
     col = kmeans_result$cluster,
     main = "Cluster Plot", 
     xlab = "Petal.Width", 
     ylab = "Sepal.Length")