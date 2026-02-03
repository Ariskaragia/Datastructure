# Data Structures (Java) — Assignments 1–3

Συλλογή εργασιών για το μάθημα **Δομές Δεδομένων** σε **Java**, με υλοποιήσεις βασικών δομών (**Deque, Priority Queue, BST**) και εφαρμογές σε πραγματικά “mini-problems” (μετατροπή εκφράσεων, top-k πόλεις, αναζήτηση καταθετών).

**Contributors**
- Αριστείδης Καραγιαννάκος (P3220066)
- Έλλη-Μαρία Δανέζη (P3220037)

---

## ✨ Overview
- Implemented a **Double-Ended Queue (Deque)** using a **doubly linked list** with **O(1)** operations; applied it to **prefix→infix conversion** and **DNA Watson–Crick palindrome checking**.
- Developed solutions for **top-k queries** on streams using **sorting (Quicksort/Heapsort)** and **Priority Queues (Min-Heaps)**, optimized when **k ≪ N**.
- Implemented a **Dynamic Median** algorithm on streams using **two priority queues** (min-heap / max-heap).
- Built a **Binary Search Tree (Symbol Table)** for `LargeDepositor` supporting **insert/search/remove/traversals** and **statistical queries** (mean values, top-k).

---

## 📚 Contents
- [Assignment 1 — Deque + Applications](#assignment-1--deque--applications)
- [Assignment 2 — Quicksort + Priority Queue (Top-k/Median)](#assignment-2--quicksort--priority-queue-top-kmedian)
- [Assignment 3 — BST LargeDepositor + Top-k](#assignment-3--bst-largedepositor--top-k)
- [Tech Stack](#tech-stack)
- [How to Run](#how-to-run)
- [Input Notes](#input-notes)

---

## Assignment 1 — Deque + Applications

### A) `StringDoubleEndedQueue` (Deque)
Υλοποίηση **Deque** με εισαγωγή/αφαίρεση από **head & tail**:
- Interface: `StringDoubleEndedQueue`
- Implementation: `StringDoubleEndedQueueImpl`
- Χρήση **Generics** ώστε να δέχεται αντικείμενα τύπου `T`

**Core methods**
- `isEmpty()`
- `addFirst()`, `removeFirst()`
- `addLast()`, `removeLast()`
- `getFirst()`, `getLast()`
- `printQueue(Stream)`
- `size()` με counter → **O(1)**

**Goal:** Deque operations σε **σταθερό χρόνο O(1)** μέσω δεικτών `head/tail/next/prev`.

### B) Prefix → Infix Converter
Με χρήση της Deque:
- Αν token είναι τελεστής: `removeLast()` δύο στοιχείων και σύνθεση `(a op b)`
- Τελικό αποτέλεσμα: το τελευταίο στοιχείο της δομής

### C) DNA Complementary Palindrome (Watson–Crick)
Έλεγχος αν DNA είναι **συμμετρικά συμπληρωματικό**:
- Ζεύγη: **A–T**, **C–G**
- Σύγκριση πρώτου-τελευταίου, δεύτερου-προτελευταίου κ.ο.κ.
- Πολυπλοκότητα: **O(N)**

---

## Assignment 2 — Quicksort + Priority Queue (Top-k/Median)

### A) Quicksort + Reading Cities
- Υλοποίηση **Quicksort** με `partition()` γύρω από pivot και αναδρομή
- `ReadCity`/`read(...)`: διάβασμα `.txt` και δημιουργία `City` objects (parsing + validation)
- Στη `main`: input **k** και εκτύπωση top-k (με check `k <= N`)

### B) `remove` in Priority Queue with position array
Για O(1) εύρεση θέσης + O(log N) αποκατάσταση heap:
- Mapping `id -> position`
- `remove(id)`: swap με last element, μετά `sink(position)` (και/ή `swim` ανάλογα)

### C) Top-k Cities using PQ
- Streaming insert σε PQ
- Κρατάμε μόνο τα **k καλύτερα**
- Όταν νέο στοιχείο “κερδίζει”: απομάκρυνση του χειρότερου και εισαγωγή του νέου
- Πράξεις PQ: **O(log k)**

### D) Median with two priority queues
- Δύο PQ (min-heap / max-heap)
- Διατήρηση ισορροπίας ώστε να υπολογίζεται median γρήγορα
- Median ανάλογα με άρτιο/περιττό πλήθος

---

## Assignment 3 — BST LargeDepositor + Top-k

Υλοποίηση **BST** με κλειδί το **ΑΦΜ** για αντικείμενα `LargeDepositor`:

- `insert(LargeDepositor item)`
- `load(String filename)`
- `updateSavings(int AFM, double savings)`
- `searchByAFM(int AFM)`
- `searchByLastName(String lastName)` (συλλογή results σε Deque από Assignment 1)
- `remove(int AFM)` (0/1/2 παιδιά με κατάλληλο successor)
- `printTopLargeDepositors(int k)` (χρήση PQ από Assignment 2)
- `printByAFM()` (in-order traversal)

> Ενδεικτικές πολυπλοκότητες:  
> `searchByLastName: O(N)`, `printTopLargeDepositors: O(N log N)` (ανάλογα με υλοποίηση/ισορροπία δέντρου).

---

## 🧰 Tech Stack
- **Java (JDK 8+)**
- Concepts: **interfaces, generics, recursion, heaps, BST, Big-O**

---

## ▶️ How to Run

> Η δομή φακέλων/ονόματα main classes μπορεί να διαφέρουν. Τα παρακάτω είναι “τυπικό” setup για plain Java.

### Prerequisites
- **JDK 8+** (recommended 11 ή 17)
- (Optional) IDE: IntelliJ / Eclipse

### Compile (example)
```bash
javac -d out src/**/*.java
