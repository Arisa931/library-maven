# Library – förklaring

Originalets 11 programklasser är oförändrade. De fyra testklasserna är ifyllda för G och VG. Paketet heter models (plural) enligt Java-filerna.

## Programkod
- Material: abstrakt basklass. equals jämför ID och titel.
- Book: ärver Material, innehåller författare och ISBN. getLoanPeriod ger 21 dagar.
- BookCatalog: array för upp till 100 böcker. addBook lägger till en bok. findBook söker exakt titel efter trim och utan hänsyn till versaler.
- Customer: kunduppgifter, kön och postnamn (titel, första initial, efternamn).
- Loan: lån med förfallodatum 14 dagar framåt. endLoan ändrar status. Skillnaden 21/14 dagar finns i originalet och har inte ändrats.
- Exception-klasser: egna undantag.
- GenderType och LoanStatus: enum med tillåtna värden.
- ui.Main: startpunkt. Söker efter Better trots att boken heter Better Java, så meddelandet om att boken inte hittades är förväntat.

## Tester
@Test markerar ett test. assertTrue/assertFalse kontrollerar boolean, assertEquals jämför värden, assertSame jämför objektreferenser, assertThrows kontrollerar undantag, assertDoesNotThrow kontrollerar att inget undantag kastas.
- BookTest: fem jämförelser av ID och titel.
- BookCatalogTest: lägg till, hitta, ignorera versaler och mellanslag, tom katalog, saknad bok, samt tre varianter av titeln via @ParameterizedTest och @ValueSource.
- CustomerTest: kön och postnamn.
- LoanTest: förfallodatum (hanterar även midnatt), ny status och avslutad status.
Totalt 17 testmetoder, 19 testfall.

## IntelliJ
Packa upp ZIP, välj File > Open och öppna projektmappen library. Välj JDK 17 eller 21 under Project Structure. Importera som Maven respektive Gradle. Kör kommandona i medföljande textfil eller via byggverktygets verktygsfönster.

## Kontroll före inlämning
Programkoden har kompilerats med javac och JAR har provkörts lokalt. JUnit 6, Maven och Gradle kunde inte köras i miljön eftersom verktygen saknas och nätverket inte är tillgängligt. Därför måste du generera riktiga target/build och verifiera alla 19 tester i IntelliJ. Inga fabricerade testrapporter ingår.
