web: bash -lc 'if [ -f /app/app.jar ]; then exec java -jar /app/app.jar; elif compgen -G "build/libs/*.jar" > /dev/null; then exec java -jar build/libs/*.jar; else echo "No JAR found"; exit 1; fi'
