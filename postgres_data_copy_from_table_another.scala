import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().appName("PostgreSQL Data Transfer").getOrCreate()
  
val df = spark.read.format("jdbc").option("url", "jdbc:postgresql://172.31.154.148:5432/test_1").option("driver", "org.postgresql.Driver").option("dbtable", "users").option("user", "root").option("password", "root").load()


df.write.format("jdbc").option("url", "jdbc:postgresql://172.31.154.148:5432/test_1").option("driver", "org.postgresql.Driver").option("dbtable", "persons").option("user", "root").option("password", "root").mode("overwrite") .save()

