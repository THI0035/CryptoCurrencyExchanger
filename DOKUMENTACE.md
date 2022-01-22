#CryptoCurrencyExchanger

Zápočtový projekt

Dokumentace - směnárna kryptoměn

Technické parametry

Autor: Adam Thiel (THI0035)
IDE: Apache NetBeanns IDE 12.0
Verze: JDK 13 
Popis aplikace: Uživatel si ze seznamu kryptoměn vybere, jaké kryptoměny chce převádět a na jaké. Kryptoměny jsou vypsány z aplikačního prostředí vždy s aktuální cenou. Výsledkem 		   aplikace je převod první, uživatelem zadané kryptoměny, na drouhou.

Použité knihovny: knihovny z bálíčku java(java.util.ArrayList,java.util.Scanner,java.util.Iterator, java.net.HttpURLConnection, java.net.URL) 
		  a dále knihovna pro práci s aktuálními JSON daty.(org.json.*)

Průvodce aplikací:

Po spuštění aplikace jsou na obrazovku vypsány všechny názvy kryptoměn pomocí výčtů enum ve třídě VycetKryptomen.java, které lze později směnit. Ve třídě VycetKryptomen jsou
názvy kryptoměn vloženy manuálně a případné změny je nutné provést přímo v kódu.
Uživatel je následně dotázán, jestli chce převádět kryptoměny y/n. Pokud uživatel zvolí že ne, aplikace je okamžitě ukončená. 
Pokud napíše že chce převádět(y), tak se na obrazovku do konzole výpíše seznam všech dostupných kryptoměn se zkratkou a aktuální cenou v dolarech.
Všechny dostupné kryptoměny jsou vypsány z Aplikačního prostředí ze stránky https://api.pancakeswap.info/api/v2/tokens. Pomocí metody getData(), ve třídě Data.java.
Metoda getData() odchytává vyjímky pomocí try catch a request metody GET. Pokud je stavový kód HTTP roven 200, což znamená, že všechno přoběhlo úspěšně, tak se postupně všechny data uloží do String data. Data jsou následně "parzována" v parseJSON, kde z JSON dat získáme zkratku a aktuální cenu každé jednotlivé kryptoměny.

Uživatel si dále ze seznamu a podle zkratky vybere, z jaké kryptoměny bude převádět a dále na jakou. Pokud napíše nějakou zkratku, nebo cokoliv jiného,
co se v seznamu nenachází, je tázán znovu, dokud nezadá správnou zkratku. Není možné převádět stejnou kryptoměnu na stejnou. Pokud uživatel chce převádět na stejnou kryptoměnu, je tázán, aby zadal jinou.
Pokud všechno proběhne úspěšně, je uživatel vyzván napsat počet mincí, které chce převést. Aplikace následně
převede první kryptoměnu na druhou a výsledek vypíše na obrazovku do konzole.

