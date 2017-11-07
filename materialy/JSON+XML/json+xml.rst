========================
Pracowania Programowania
========================

----------
JSON & XML
----------

.. contents::

JSON
====
`JSON (JavaScript Object Notation) <http://www.json.org/>`_   to lekki, tekstowy format wymiany danych.

Jest oparty na podzbiorze języka JavaScript.

Powszechnie wykorzystywany do przechowywania i przekazywania ustrukturyzowanych danych w postaci tekstowej.

- czytelny dla człowieka
- szeroko rozpowszechniony - biblioteki dla każdego języka (lista na http://www.json.org) 

Przykład JSON
~~~~~~~~~~~~~
.. code:: json
        
    {
        "artist": "Pink Floyd",
        "title": "Dark Side of the moon",
        "year": 1973,
        "tracks": [
            {
                "track#": 1,
                "title": "Speak to Me/Breathe",
                "length": "3:57",
                "music": ["Mason"]
            },
            {
                "track#": 2,
                "title": "On the run",
                "length": "3:50",
                "music": ["Waters", "Gilmour"]
            }
        ]
    }

Przykład z życia: `API rowerów miejskich <http://www.poznan.pl/mim/plan/map_service.html?mtype=pub_transport&co=stacje_rowerowe>`_


Składnia JSON
~~~~~~~~~~~~~

Dwie struktury danych:

- **object** (obiekt, słownik) 
  zbiór par klucz-wartość

.. code:: json

        {
        "title": "Dark Side of the Moon",
        "year": 1973,
        "tracks#": 9
        }

.. image:: img/object.gif
        :align: center


- **array** (tablica, lista)
   uporządkowany zbiór wartości

.. code:: json

        ["Gilmour", "Mason", "Waters", "Wright"]

.. image:: img/array.gif
        :align: center


Siedem typów wartości:

.. image:: img/value.gif
        :align: center





XML
===
XML (Extensible Markup Language) - język znaczników (markup language),
który podobnie jak JSON umożliwia serializację i wymianę strukturalnych danych 
w postaci tekstowej.


Składnia XML
~~~~~~~~~~~~

W dokumencie XML możemy wydzielić *zawartość* (*content*) i * *znaczniki* (*markup*).

Znaczniki znajdują się między parami znaków "<" i ">" lub "&" i ";".

Treść dokumentu to wszystkie znaki, które nie są znacznikami.


Tagi
----
- tagi początku elementu:

.. code:: xml

   <album>

- tagi końca elementu:

.. code:: xml

   </album>

- tagi puste (bez zawartości):

.. code:: xml

    <album />

Element
-------
Element rozpoczna się tagiem początku, kończy tagiem końca elementu, albo jest pustym tagiem.

Pomiędzy tagami znajduje się zawartość elementu, którym może być albo zwykły tekst, albo zagnieżdżone elementy.

Tagi początkowy i pusty mogą zawierać atrybuty, czyli pary klucz-wartość.

Klucz bez cudzysłowów, wartości zawsze w cudzysłowie.

.. code:: xml

        <track number="3" title="Time" length="3:57">
            Ticking away the moments that make up a dull day
            You fritter and waste the hours in an offhand way
            Kicking around on a piece of ground in your home town
            Waiting for someone or something to show you the way
        </track>


Komentarze
----------
Komentarze znajdują się między znacznikami "<!--" i "-->". 


Przykład XML
~~~~~~~~~~~~

.. code:: xml

    <?xml version="1.0" encoding="UTF-8"?> 
    <album title="Dark Side of the Moon" year="1973">
        <track number="1" title="Speak to Me/Breathe">
            Breathe, breathe in the air
            Don't be afraid to care
            Leave but don't leave me
            Look around and choose your own ground
            For long you live and high you fly
            Smiles you'll give and tears you'll cry
            And all you touch and all you see
            Is all your life will ever be
        </track>
        <track number="2" title="On the run" />
        <track number="3" title="Time" length="3:57">
            Ticking away the moments that make up a dull day
            You fritter and waste the hours in an offhand way
            Kicking around on a piece of ground in your home town
            Waiting for someone or something to show you the way
        </track>
    </album>




Życiowy przykład: `API rowerów miejskich, XML <https://nextbike.net/maps/nextbike-official.xml?city=192>`_


Serializacja / Deserializacja
=============================

Serializacja - proces polegający na przekształceniu struktur danych albo stanu obiektu do sekwencyjnej formy, która umożliwa zapisanie lub przesłanie tych danych i potencjalnie odtworzenie struktur danych lub obiektów w późniejszym czasie/przez inny proces/komputer (deserializację).

Na przykład, serializacja może polegać na zapisie do pliku w formacie JSON obiektów wygenerowanych przez nasz program, w celu późniejszego wczytania tych obiektów z powrotem do programu w celu kontynuowania obliczeń.

JSON i XML są przykładami formatów dobrze nadających się do serializacji danych w sposób czytelny dla człowieka.
Można również serializować dane w postaci binarnej, niezrozumiałej dla człowieka.

GSON
~~~~
`GSON <https://github.com/google/gson>`_ to biblioteka języka Java służąca do (de)serializacji JSON.

 - stworzona i rozwijana przez Google 
 - udostępniona na otwartej licencji Apache License 2.0.
 - łatwa w użyciu
 - nie wymaga (ale umożliwia) dodawania adnotacji do serializowanych klas
 - może być użyta na kodzie, którego nie możemy modyfikować


Rrzykład 1: typy proste
-----------------------

.. code:: Java

    // Serialization
    Gson gson = new Gson();
    gson.toJson(1);            // ==> 1
    gson.toJson("abcd");       // ==> "abcd"
    gson.toJson(new Long(10)); // ==> 10
    int[] values = { 1 };
    gson.toJson(values);       // ==> [1]

    // Deserialization
    int one = gson.fromJson("1", int.class);
    Integer one = gson.fromJson("1", Integer.class);
    Long one = gson.fromJson("1", Long.class);
    Boolean false = gson.fromJson("false", Boolean.class);
    String str = gson.fromJson("\"abc\"", String.class);
    String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);


Przykład 2: tablice
-------------------

.. code:: Java

    Gson gson = new Gson();
    int[] ints = {1, 2, 3, 4, 5};
    String[] strings = {"abc", "def", "ghi"};

    // Serialization
    gson.toJson(ints);     // ==> [1,2,3,4,5]
    gson.toJson(strings);  // ==> ["abc", "def", "ghi"]

    // Deserialization
    int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class); 
    // ==> ints2 will be same as ints


Przykład 3: obiekty
-------------------
.. code:: Java

    class BagOfPrimitives {
      private int value1 = 1;
      private String value2 = "abc";
      private transient int value3 = 3;
      BagOfPrimitives() {
        // no-args constructor
      }
    }

    // Serialization
    BagOfPrimitives obj = new BagOfPrimitives();
    Gson gson = new Gson();
    String json = gson.toJson(obj);  

    // ==> json is {"value1":1,"value2":"abc"}


Uwagi:
 - `transient <https://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.3.1.3>`_ - słowo kluczowe Java, oznaczające, że dane pole nie ma podlegać serializacji
 - prywatne pola też są serializowane/deserializowane
 - pola mające wartość null nie są serializowane
 - jeśli jakiegoś pola brakuje w jsonie, to przy deserializacji przyjmuje ono wartość domyślną (tak, jakbyśmy nie zainicjowali zmiennej: obiekty null, numeryczne 0 a boolowiskie false)

Przykład 4: kolekcje
--------------------

.. code:: Java

    Gson gson = new Gson();
    Collection<Integer> ints = Lists.immutableList(1,2,3,4,5);

    // Serialization
    String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]

    // Deserialization
    Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
    Collection<Integer> ints2 = gson.fromJson(json, collectionType);
    // ==> ints2 is same as ints

Uwagi:
 - Podczas deserializacji generycznych typów należy uzyć specjalnej klasy *TypeToken* w celu uzyskania typu wynikowej kolekcji, która zostanie stworzona w wyniku deserializacji ( więcej na ten temat `tutaj <https://github.com/google/gson/blob/master/UserGuide.md#serializing-and-deserializing-generic-types>`_ ).
   
    
Zadanie 1
---------

 Dodaj Gson do pom.xml

 .. code:: xml

    <dependencies>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.2</version>
        </dependency>
    </dependencies>


Zadanie 2
---------

...

Jackson
~~~~~~~~~~~

`Jackson <https://github.com/FasterXML/jackson>`_ - zestaw narzędzi do przetwarzania danych dla Javy ("suite of data-processing tools for Java").

Głównym komponentem jest generator/parser JSON, pozwalający m.in. na deserializację/serializację do/z JSON z/do Javy.

Posiada liczne moduły dodające obsługę innych formatów danych, m.in. XML, YAML czy CSV.

Strona domowa projektu nie działa, ale projekt jest aktywnie rozwijany na `GitHub <https://github.com/FasterXML/jackson>`_.
`Zarchiwizowana wersja strony domowej <https://web.archive.org/web/20170801130759/http://wiki.fasterxml.com/JacksonHome>`_.


Zadanie 3: Serializacja do JSON
--------------------------------

Dodaj bibliotekę Jackson do pom.xml

.. admonition:: Wskazówka

    Odpowiedni wpis znajdzie w dokumentacji w `repozytorium GitHub modułu <https://github.com/FasterXML/jackson-databind/#maven>`_.


Stwórz dwóch pracowników (obiekty klasy Employee). Niech jeden pracownik będzie przełożonym a drugi jego podwładnym.

Każdemu z pracowników przypisz adres.

Za pomocą om.fasterxml.jackson.databind.ObjectMapper zapisz (dokonaj serializacji) obiektu przełożonego do pliku json.


Zadanie 4: Deserializacja z JSON
--------------------------------

Odtwórz obiekt przełożonego z utworzonego w zdaniu 3. pliku JSON.
Zmień przełożonemu wynagrodzenie i zapisz (dokonaj serializacji) do pliku json.


Zadanie 5: annotacje
--------------------

W języku Java dla zapisu nazwy pól klasy przyjmuje się konwencję notacji `lowerCamelCase <https://pl.wikipedia.org/wiki/CamelCase>`_.

W JSON nie ma przyjętego standardu notacji (`dyskusja na StackOverflow <https://stackoverflow.com/questions/5543490/json-naming-convention>`_).

Choć camelCase wydaje się bardziej popularny, to jednak konwencja może zmieniać się w zależności od projektu.
Domyślnie pola w JSONie wygenerowanym przez Jackson/Gson mają takie same nazwy jak pola w klasie, którą serializujemy.
Dodaj do modelowanych klas annotacje, które zmienią zserializowane nazwy pól na zgodne z konwencją `snake_case <https://en.wikipedia.org/wiki/Snake_case>`_.


.. admonition:: Wskazówka

    Skorzystaj z `dokumentacji <https://github.com/FasterXML/jackson-databind/#annotations-changing-property-names>`_.


Zadanie 6: deserializacja typów generycznych
--------------------------------------------

Stwórz plik json zawierający listę kilku pracowników.
Wczytaj tę listę do kolekcji ArrayList<Employee>.

.. admonition:: Wskazówka

    Skorzystaj z `3 minute tutorial <https://github.com/FasterXML/jackson-databind/#3-minute-tutorial-generic-collections-tree-model>`_.



Jackson XML
-----------
Jackson posiada `moduł <https://github.com/FasterXML/jackson-dataformat-xml>`_
rozszerzający go o obsługę formatu XML.
Aby użyć XML zamiast JSON wystarczy zmienić "ObjectMapper" na XmlMapper":

.. code:: Java

    ObjectMapper xmlMapper = new XmlMapper();

Zadanie: XML
------------
Korzystając z istniejącej klasy JacksonSerialization zmodyfikuj ją, albo stwórz nową klasę tak, żeby umożliwić serializację / deserializację do/z formatu XML.
Dodaj do katalogu main/resources pliki xml odpowiadające istniejącym już plikom json.

.. admonition:: Wskazówka

    Nie muszisz tworzyć zawartości plików xml samodzielnie, możesz wygenerować je za pomocą odpowiednich metod.

    
.. admonition:: Wskazówka

    Pamiętaj żeby dodać bibliotekę do pom.xml. Odpowiedni wpis znajdziesz w `repozytorium GitHub modułu XML <https://github.com/FasterXML/jackson-dataformat-xml#maven-dependency>`_.

Zadanie: Joda Time
------------------
Dodaj do klasy Employee pole LocalDate birthDate zawierające datę urodzenia pracownika.
Spróbuj dokonać serializacji a następnie deserializacji obiektu tak zmodyfikowanej klasy.

.. admonition:: Wskazówka

    Możesz potrzebować modułu `jackson-datatype-joda <https://github.com/FasterXML/jackson-datatype-joda>`_.

