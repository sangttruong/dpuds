## ---- warning = FALSE----------------------------------------------------
# Load the raw data
setwd("/Users/sangtruong_2021/Desktop/XTernDataScience2019")
raw = read.csv("raw.csv")

# Review raw dataset
head(raw)
dim(raw)
plot(raw[, c(2, 3)], cex = 2, pch = 1, lwd = 2, col = "grey", main = "Figure 1. 25668 scooters grouping in 19 clusters")

# Hierachial cluster
library(cluster)
hclust = hclust(dist(raw[, c(2, 3)]), method = "complete")
plot(hclust)
cst = cutree(hclust, 19)
x = cbind(raw, cst)

# Generate starting and ending point
u = matrix(c(20.19, 20.19,0), ncol = 3)
colnames(u) = c("xcoordinate", "ycoordinate", "cstNum")

# Compute medoids for each cluster
for (i in 1:19){
  v = pam(x[x$cst == i, c(2, 3)], 1)$medoids
  cstNum = matrix(i, ncol = 1)
  v = cbind(v, cstNum)
  u = rbind(u, v)
}

# Format u to dataframe and print it out
u = data.frame(u)
print(u)

# Plotting 19 clusters in raw data and their medoids
plot(x[, c(2, 3)], cex = 2, pch = 20, lwd = 2, col = "gray", main = "Figure 2. Medoids of 19 clusters")
points(u[-1, ], cex = 1, pch = 20, lwd = 2, col = "blue")
with(u[-1, ], text(ycoordinate~xcoordinate, labels = cstNum, pos = 4))


## ---- warning = FALSE----------------------------------------------------
# Visualize cluster 1, 5, 10, and 19
plot(x[x$cst == 1, c(2, 3)], cex = 1, col = x$power_level, pch = 20, main = "Figure 3.1. Cluster 1")
plot(x[x$cst == 5, c(2, 3)], cex = 1, col = x$power_level, pch = 20, main = "Figure 3.2. Cluster 5")
plot(x[x$cst == 10, c(2, 3)], cex = 1, col = x$power_level, pch = 20, main = "Figure 3.3. Cluster 10")
plot(x[x$cst == 19, c(2, 3)], cex = 1, col = x$power_level, pch = 20, main = "Figure 3.4. Cluster 19")


## ---- warning = FALSE----------------------------------------------------
# (Install and ) Import Traveling Saleperson Problem (TSP) package
# Only install the package if you have not had it installed
# install.packages("TSP")
library(TSP)

# Total path
TPath = ETSP(u[, -3])
TPathTour = solve_TSP(TPath, method = "repetitive_nn", two_opt = TRUE)
print(TPathTour)
plot(TPath, TPathTour, cex=1, pch=20, lwd=2, col = "blue", main = "Figure 4.1. Total path")

# Cluter-to-cluster path
CPath = ETSP(u[-1, -3])
CPathTour = solve_TSP(CPath, method = "repetitive_nn", two_opt = TRUE)
print(CPathTour)
plot(CPath, CPathTour, cex = 1, pch = 20, lwd = 2, col = "blue", main = "Figure 4.2. Cluster-to-cluster path")

# Within cluter path
xU5 = x[x$power_level < 5, ]
print(dim(xU5))

## Cluster 1
WPath1 = ETSP(xU5[xU5$cst == 1, c(2, 3)])
WPathTour1 = solve_TSP(WPath1, method = "repetitive_nn", two_opt = TRUE)
print(WPathTour1)
plot(WPath1, WPathTour1, cex = 1, pch = 20,col = xU5[xU5$cst == 1, 4], main = "Figure 4.3.1 Within cluster 1 path")

## Cluster 5
WPath5 = ETSP(xU5[xU5$cst == 5, c(2, 3)])
WPathTour5 = solve_TSP(WPath5, method = "repetitive_nn", two_opt = TRUE)
print(WPathTour5)
plot(WPath5, WPathTour5, cex = 1, pch = 20,col = xU5[xU5$cst == 5, 4], main = "Figure 4.3.2. Within cluster 5 path")

## Cluster 10
WPath10 = ETSP(xU5[xU5$cst == 10, c(2, 3)])
WPathTour10 = solve_TSP(WPath10, method = "repetitive_nn", two_opt = TRUE)
print(WPathTour10)
plot(WPath10, WPathTour10, cex = 1, pch = 20,col = xU5[xU5$cst == 10, 4], main = "Figure 4.3.3 Within cluster 10 path")

## Cluster 19
WPath19 = ETSP(xU5[xU5$cst == 19, c(2, 3)])
WPathTour19 = solve_TSP(WPath19, method = "repetitive_nn", two_opt = TRUE)
print(WPathTour19)
plot(WPath19, WPathTour19, cex = 1, pch = 20,col = xU5[xU5$cst == 19, 4], main = "Figure 4.3.4. Within cluster 19 path")

## Cluster 19 with all dot in black
plot(WPath19, WPathTour19, cex = 1, pch = 20, main = "Figure 4.3.5. Within cluster 19 path (all dots in black")


## ---- eval = FALSE, warning=FALSE----------------------------------------
## # Import some important package
## import pandas as pd
## import numpy as np
## from matplotlib import pyplot as plt
## from matplotlib.pyplot import cm
## from sklearn.cluster import AgglomerativeClustering
## import scipy.cluster.hierarchy as sch
## 
## # Load dataset
## raw = read.csv("Raw.csv")
## raw.head()
## 
## # Hierachial clustering
## x = raw.iloc[:, [1, 2]].values
## dendrogram = sch.dendrogram(sch.linkage(x, method = 'complete'))
## model = AgglomerativeClustering(n_clusters = 19, affinity = 'euclidean', linkage = 'complete')
## model.fit(x)
## labels = model.labels_


## ---- warning = FALSE----------------------------------------------------
# K-Mean clustering on raw data with k = 2
km.x2 = kmeans(raw[, c(2, 3)], 2, 100)
plot(raw[, c(2, 3)],col = km.x2$cluster, cex = 2, pch = 1, lwd = 2)
cst = km.x2$cluster
x = cbind(raw,cst)

# Separate the data into 2 portions
x1 = x[x$cst == 1, -5]
x2 = x[x$cst != 1, -5]

# Hierarchical Clustering on portion 1
hclust1 = hclust(dist(x1[, c(2, 3)]), method = "complete")
plot(hclust1)
# Check to see how many clusters we have (from dendrogram) to decide how to cut the tree in the step
cst = cutree(hclust1, 10)
x1 = cbind(x1, cst)

# Hierarchical Clustering on portion 2
hclust2 = hclust(dist(x2[, c(2, 3)]), method = "complete")
plot(hclust2)
# Decide how to cut the tree based on the number of cluster in portion 1
cst = cutree(hclust2, 9)
# Increment cluster number by 10 (or 9) unit so that it will not overlapping with cluster number in portion 1. 
cst = cst + 10
x2 = cbind(x2, cst)

# Combind the result after hierarchical clustering
x = rbind(x1, x2)
plot(x[, c(2, 3)], col = x$cst, cex = 2, pch = 20, lwd = 2)

head(x)

# K-Mean clustering on raw data with k = 19
km.x19 = kmeans(raw[,c(2,3)], 19, 100)
plot(raw[, c(2, 3)],col = km.x19$cluster, cex = 2, pch = 1, lwd = 2, main = "Figure 6. K-Mean clustering with k = 19 does not work on raw dataset")


## ---- eval = FALSE, warning=FALSE----------------------------------------
## # (Install and ) Loading rpivotTable
## # install.packages("rpivotTable")
## library(rpivotTable)
## 
## #Generate bar chart of average power level by cluster
## rpivotTable(x, rows = "cst", vals = "power_level",
##             aggregatorName = "Average", rendererName = "Bar Chart")
## 
## # Generate number of scooters by cluster, breaking down by power levels
## rpivotTable(x, rows = "power_level", cols = "cst",
##             aggregatorName = "Count",  rendererName = "Stacked Bar Chart")


## ---- eval = FALSE, warning=FALSE----------------------------------------
## library(shiny)
## library(shinydashboard)
## library(rpivotTable)
## 
## # Chart 1: Average power level by cluster
## header <- dashboardHeader(disable = TRUE)
## sidebar <- dashboardSidebar(disable = TRUE)
## body <- dashboardBody(
##   box(title = "Pivot",
##       width ="100%",
##       height = "100%",
##       status = "primary",
##       solidHeader = TRUE,
##       tags$head(tags$style(type = 'text/css','#test{ overflow-x: scroll; }')),
##       rpivotTableOutput("test")
## ))
## shinyApp(
##   ui = dashboardPage(header, sidebar, body),
##   server = function(input, output) {
##     output$test <- rpivotTable::renderRpivotTable({
##       rpivotTable(x,
##                   rows = "cst",
##                   vals = "power_level",
##                   aggregatorName = "Average",
##                   rendererName = "Bar Chart")
##     })
##   }
## )
## 
## # Chart 2: Number of scooters by cluster, breaking down by power levels
## header <- dashboardHeader(disable=TRUE)
## sidebar <- dashboardSidebar(disable=TRUE)
## body <- dashboardBody(
##   box(title = "Pivot",
##       width ="100%",
##       height = "100%",
##       status = "primary",
##       solidHeader = TRUE,
##       tags$head(tags$style(type = 'text/css','#test{ overflow-x: scroll; }')),
##       rpivotTableOutput("test")
## ))
## shinyApp(
##   ui = dashboardPage(header, sidebar, body),
##   server = function(input, output) {
##     output$test <- rpivotTable::renderRpivotTable({
##       rpivotTable(x,
##                   rows = "power_level",
##                   cols = "cst",
##                   aggregatorName = "Count",
##                   rendererName = "Stacked Bar Chart")
##     })
##   }
## )


## ----message=FALSE, warning=FALSE, include=FALSE, paged.print=FALSE------
# Convert R Mardown (this document) to R Script to share on GitHub
library(knitr)
purl("main.Rmd")

