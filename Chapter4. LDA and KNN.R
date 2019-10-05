# Load packets
require(ISLR)
require(MASS)

# Linear discriminant analysis
??lda
lda.fit=lda(Direction~Lag1+Lag2,data=Smarket,subset=Year<2005)
lda.fit
plot(lda.fit)
Smarket.2005=subset(Smarket,Year=2005)
lda.pred=predict(lda.fit,Smarket.2005)
lda.pred[1:5,]
data.frame(lda.pred)[1:5,]
table(lda.pred$class,Smarket$Direction)
mean(lda.pred$class==Smarket.2005$Direction)

# K-Nearest neighbor
library(class)
?knn
attach(Smarket)
ls()
Xlag=cbind(Smarket$Lag1,Smarket$Lag2)
Xlag[1:5,]
train=Year<2005
train[1:5]
#K = 1
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=1)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])

#K = 2
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=2)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])

#K = 3
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=3)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])

#K = 4
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=4)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])

#K = 5
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=5)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])

#K = 6
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=6)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])

#K = 7
knn.pred=knn(Xlag[train,],Xlag[!train,],Direction[train],k=7)
table(knn.pred,Direction[!train])
mean(knn.pred==Direction[!train])