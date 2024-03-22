# Hotel Management System

## Opis
Hotel Management System to prosty system do zarządzania pokojami hotelowymi. Pozwala na dodawanie, przeglądanie, zameldowanie, wymeldowanie, zapisywanie i wczytywanie danych o pokojach.

## Struktura projektu
Projekt składa się z następujących pakietów:

- `io`: Zawiera klasy odpowiedzialne za operacje wejścia/wyjścia, takie jak czytanie i zapisywanie danych do pliku Excel.
- `maparoommanager`: Zawiera klasy związane z zarządzaniem pokojami, w tym klasę `HotelManager` do głównego zarządzania pokojami oraz klasę `Room` reprezentującą pojedynczy pokój.
- `panelrozruchowy`: Zawiera główną klasę programu.

## Instrukcje użytkowania

### Komendy
- `list`: Wyświetla listę wszystkich pokoi w hotelu.
- `view <numer_pokoju>`: Wyświetla szczegółowe informacje o danym pokoju.
- `checkin <numer_pokoju> <nazwa_goscia>`: Zameldowuje gościa do pokoju.
- `checkout <numer_pokoju>`: Wymeldowuje gościa z pokoju.
- `save <nazwa_pliku>`: Zapisuje dane o pokojach do pliku Excel.
- `load <nazwa_pliku>`: Wczytuje dane o pokojach z pliku Excel.
- `add <numer_pokoju> <opis_pokoju> <cena>`: Dodaje nowy pokój do hotelu.
- `exit`: Zamyka program.

### Uruchamianie
Aby uruchomić program, przejdź do katalogu `main` i uruchom główną klasę `HotelManagementSystem`.

## Zależności
Projekt wykorzystuje bibliotekę Apache POI do obsługi plików Excel.

## Autor
Autor: Lucjan Bator
