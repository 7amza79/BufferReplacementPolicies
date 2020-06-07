library(data.table)


png("output_graph.png", width = 920, height = 920)
tab <- read.table("Output.csv", header = TRUE, sep = ",")
plot(x = tab$size, y = tab$Clock, type = "l", col = "black",
     ylab = "Number of page faults", xlab = "buffer size", lwd = "2",
     main = "Performance comparaison of cache replacement 
     algorithms \n using 10K page set normally distributed ")
lines(x = tab$size, y = tab$FIFO, type = "l", col = "red", lwd = "2")
lines(x = tab$size, y = tab$LRU, type = "l", col = "blue", lwd = "2")
legend("topright", c("Clock", "FIFO", "LRU"), lwd = "2",
       col = c("black", "red", "blue"))
dev.off()