### Vectors, data, matrices, subsetting
x=c(2,7,5)
x

y=seq(from=4,length=3,by=3)
?seq
y
x+y
x*y
x[2]
x[2:3]
x[-2]
z = matrix(seq(1,12),4,3)
z
z[3:4,2:3]
z[,2:3]
z[,1]
z[,1, drop = FALSE]

ls()
x = runif(50)
y = rnorm(50)
plot(x,y)
