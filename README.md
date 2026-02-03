# Data Structures (Java) — Assignments 1–3

Συλλογή εργασιών για το μάθημα **Δομές Δεδομένων** σε **Java**, με υλοποιήσεις βασικών δομών (Deque, Priority Queue, BST) και εφαρμογές πάνω σε πραγματικά “mini-problems” (μετατροπή εκφράσεων, top-k πόλεις, αναζήτηση καταθετών). 

**Συντελεστές:**  
- Αριστείδης Καραγιαννάκος (P3220066)  
- Έλλη-Μαρία Δανέζη (P3220037) :contentReference[oaicite:3]{index=3}


---

## Περιγραφή
- Implemented a Double-Ended Queue (Deque) using a doubly linked list with O(1) operations; applied it to prefix-to-infix conversion and DNA Watson–Crick palindrome checking. 
- Developed solutions for top-k queries on data streams using sorting (Quicksort/Heapsort) and Priority Queues (Min-Heaps), achieving improved performance when k ≪ N. 
- Implemented a Dynamic Median algorithm on data streams using two priority queues (min-heap / max-heap). 
- Built a Randomized Binary Search Tree (Symbol Table) supporting insert, search, remove, traversals, and statistical queries (mean values, top-k queries). 

---

---

## Περιεχόμενα
- [Εργασία 1 — Deque + Εφαρμογές](#εργασία-1--deque--εφαρμογές)
- [Εργασία 2 — Quicksort + Priority Queue (Top-k/Median)](#εργασία-2--quicksort--priority-queue-top-kmedian)
- [Εργασία 3 — BST LargeDepositor + Top-k](#εργασία-3--bst-largedepositor--top-k)
- [Τεχνολογίες](#τεχνολογίες)
- [Εκτέλεση](#εκτέλεση)
- [Σημειώσεις εισόδου](#σημειώσεις-εισόδου)

---

## Εργασία 1 — Deque + Εφαρμογές

### Θέμα A: `StringDoubleEndedQueue` (Deque)
Υλοποίηση **Double-Ended Queue** (εισαγωγή/αφαίρεση από head & tail) με:
- **Interface** `StringDoubleEndedQueue`
- Υλοποίηση `StringDoubleEndedQueueImpl`
- Χρήση **generics** ώστε να δέχεται οποιοδήποτε `T` αντικείμενο. :contentReference[oaicite:4]{index=4}

Βασικές μέθοδοι (ενδεικτικά):
- `isEmpty()`
- `addFirst()`, `removeFirst()`
- `addLast()`, `removeLast()`
- `getFirst()`, `getLast()`
- `printQueue(Stream)`
- `size()` με counter → **O(1)** :contentReference[oaicite:5]{index=5}

> Στόχος: λειτουργίες Deque σε **σταθερό χρόνο O(1)** μέσω δεικτών head/tail/next/prev. :contentReference[oaicite:6]{index=6}

### Θέμα B: Prefix → Infix Converter
Χρήση της Deque της Εργασίας 1 για μετατροπή από **προθεματική (prefix)** σε **ενθεματική (infix)** μορφή:
- Έλεγχος αν token είναι τελεστής ή αριθμός
- Σε τελεστή: γίνεται `removeLast` δύο στοιχείων και σύνθεση `(a op b)` για σωστή προτεραιότητα πράξεων
- Τελικό αποτέλεσμα: το τελευταίο στοιχείο της λίστας. :contentReference[oaicite:7]{index=7}

### Θέμα Γ: DNA Complementary Palindrome
Έλεγχος αν μια ακολουθία DNA είναι **συμμετρικά συμπληρωματική** (Watson–Crick complement):
- Συμπληρωματικά ζεύγη: **A–T**, **C–G** (και αντίστροφα)
- Σύγκριση πρώτου-τελευταίου, δεύτερου-προτελευταίου κ.ο.κ.
- Πολυπλοκότητα: **O(N)** λόγω ενός loop πάνω στο μήκος του DNA. :contentReference[oaicite:8]{index=8}

---

## Εργασία 2 — Quicksort + Priority Queue (Top-k/Median)

### Θέμα A: Quicksort + Ανάγνωση πόλεων
- Υλοποίηση **Quicksort** με `partition()` γύρω από pivot (`larg`) και αναδρομικό διαχωρισμό υποπινάκων. :contentReference[oaicite:9]{index=9}
- `ReadCity`/`read(...)`: διάβασμα `.txt` γραμμή-γραμμή και δημιουργία αντικειμένων `City` (parsing με split και έλεγχο αριθμητικών μέσω `try/catch`). :contentReference[oaicite:10]{index=10}
- Στη `main`: ο χρήστης δίνει **k** (πόσες πόλεις να εμφανιστούν). Γίνεται ταξινόμηση και εκτύπωση, με έλεγχο `k <= length`. :contentReference[oaicite:11]{index=11}

### Θέμα B: `remove` σε Priority Queue με position array
Για γρήγορη διαγραφή στοιχείου από PQ:
- Κρατάμε **πίνακα θέσεων** (mapping `id -> position`)
- Στο `remove(id)`: βρίσκουμε άμεσα τη θέση, κάνουμε swap με το τελευταίο και “ξαναφτιάχνουμε” την ουρά με `sink(position)`. :contentReference[oaicite:12]{index=12}

### Θέμα Γ: Top-k πόλεις με PQ (log k)
- Διαβάζουμε πόλεις και τις προσθέτουμε σε PQ, με `swim` ώστε να παραμένει σε φθίνουσα σειρά.
- Κρατάμε μόνο τα **k καλύτερα στοιχεία**: αν το νέο στοιχείο “κερδίζει”, αφαιρούμε το μέγιστο και βάζουμε το νέο.
- Εκτύπωση των k στοιχείων από μικρότερο → μεγαλύτερο με `getmin()`. :contentReference[oaicite:13]{index=13}
- Ανάλυση πολυπλοκότητας που δίνεται: τελικά εκφράζεται ως **O(log k)** ως προς τις βασικές πράξεις PQ (για μικρά k είναι ιδιαίτερα αποδοτικό). :contentReference[oaicite:14]{index=14}

### Θέμα Δ: Median με δύο ουρές
Χρήση δύο PQ:
- μία που κρατά μέχρι **k**
- μία που κρατά **όλα**
και στο τέλος υπολογισμός median ανάλογα αν το πλήθος είναι ζυγό/μονό, μέσω επαναλαμβανόμενων `getmin()` μέχρι τη μέση. :contentReference[oaicite:15]{index=15}

---

## Εργασία 3 — BST LargeDepositor + Top-k

Υλοποίηση δέντρου αναζήτησης (**BST**) με κλειδί το **ΑΦΜ**, για αντικείμενα `LargeDepositor`, και βασικές λειτουργίες:

- `insert(LargeDepositor item)`: εισαγωγή στη ρίζα ή σε αριστερό/δεξί υποδέντρο ανάλογα με το ΑΦΜ. :contentReference[oaicite:16]{index=16}  
- `load(String filename)`: διάβασμα αρχείου και εισαγωγή καταθετών με `insert`. :contentReference[oaicite:17]{index=17}  
- `updateSavings(int AFM, double savings)`: ενημέρωση αποταμιεύσεων αν βρεθεί ο κόμβος. :contentReference[oaicite:18]{index=18}  
- `searchByAFM(int AFM)`: αναζήτηση με βάση το κλειδί ΑΦΜ. :contentReference[oaicite:19]{index=19}  
- `searchByLastName(String last_name)`: συλλογή αποτελεσμάτων σε λίστα τύπου `StringDoubleEndedQueueImpl` (από Εργασία 1) μέσω αναδρομικής διάσχισης. :contentReference[oaicite:20]{index=20}  
- `remove(int AFM)`: αφαίρεση κόμβου με περιπτώσεις (0/1/2 παιδιά) και εύρεση κατάλληλου αντικαταστάτη. :contentReference[oaicite:21]{index=21}  
- `printTopLargeDepositors(int k)`: χρήση της **PriorityQueue** από Εργασία 2 για top-k καταθέτες, μέσω compare. :contentReference[oaicite:22]{index=22}  
- `printByAFM()`: αναδρομική εκτύπωση όλων των στοιχείων. :contentReference[oaicite:23]{index=23}  

> Οι πολυπλοκότητες αναφέρονται στο report ανά μέθοδο (π.χ. `searchByLastName: O(N)`, `printTopLargeDepositors: O(N log N)` κ.λπ.). :contentReference[oaicite:24]{index=24}

---

## Τεχνολογίες
- **Java**
- Βασικές έννοιες: interfaces, generics, recursion, time complexity (Big-O) :contentReference[oaicite:25]{index=25} :contentReference[oaicite:26]{index=26} :contentReference[oaicite:27]{index=27}

---

## Εκτέλεση

> Επειδή η ακριβής δομή φακέλων/ονόματα main classes μπορεί να διαφέρουν στο repo, παρακάτω είναι ο “τυπικός” τρόπος εκτέλεσης σε plain Java.

### Προαπαιτούμενα
- JDK 8+ (προτείνεται 11 ή 17)
- (Προαιρετικά) IDE: IntelliJ / Eclipse

### Compile (παράδειγμα)
```bash
javac -d out src/**/*.java
