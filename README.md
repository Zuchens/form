Żeby puścić program klikamy w run.bat \\
W momencie w którym pojawi się informacja na samym dole\\
```
[INFO] Started Jetty Server
```
możemy wejść w przeglądarke na stronę: \\
http://localhost:8080/

Zapisujemy dwie informacje
- o pacjencie - zakończone potwierdzeniem "Zapisz podstawowe dane pacjenta" (robimy to jednorazowo dla każdego pacjenta)
    Informacje są zapisane w folderze persons jako "person_(id pacjenta).json", jeśli pacjent już istnieje nie trzeba wprowadzać tych informacji ponownie.
- o dniu w szpitalu - zakończone "Zapisz dzień"
    Informacje są zapisane w folderze persons jako "person_(id pacjenta)_(numer dnia).json".

Jeśli w polu Id pacjenta zapiszemy pacjenta, który jest już w bazie system zapropnuje wykorzystanie poprzedniego dnia jako bazy do wprowadzenia zamian na dzień następny.
W momencie wpisania dnia i pacjenta, który już istnieje automatycznie wypełni się już zapisanymi danymi, które można poprawić.

Został dodany przykładowy dzień 1 dla pacjenta 1. Jeśli zostanie wpisane w polach:
 - "Id pacjenta": 1
 - "Dzień" : 1

Dane z plików zostaną załadowane.