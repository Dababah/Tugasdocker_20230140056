# Gunakan OpenJDK 17 (sesuai dengan versi Java yang umum digunakan di Spring Boot 3/4)
FROM openjdk:17-jdk-alpine

# Menentukan direktori kerja di dalam container
WORKDIR /app

# Menyalin file .jar dari folder target ke dalam container
# Pastikan nama file .jar sesuai dengan hasil build Anda di folder target/
COPY target/*.jar app.jar

# Menjalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]