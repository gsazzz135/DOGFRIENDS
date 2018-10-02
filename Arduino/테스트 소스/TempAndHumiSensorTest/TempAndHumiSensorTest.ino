#include <DHT.h>
#include <DHT_U.h>

#define DHTPIN 2
#define DHTTYPE DHT11

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin();

}

void loop() {
  float humidity = dht.readHumidity();
  float temperature = dht.readTemperature();

  if(isnan(humidity) || isnan(temperature)){
    Serial.println("Failed to read from DHT sensor!");
    return;
  }

  Serial.print((int)temperature);
  Serial.print("C, ");
  Serial.print((int)humidity);
  Serial.println("% ");

  delay(1000);
}




//온습도계 소스 출처 : https://kocoafab.cc/tutorial/view/379
//코딩하기전에 DHT11 라이브러리 설치해야 합니다.
