public interface TaxEvasionInterface {
void insert(LargeDepositor item);
void load(String filename,RandomizedBST bst);
void updateSavings(int AFM, double savings);
LargeDepositor searchByAFM(int AFM);
StringDoubleEndedQueueLmpl<LargeDepositor> searchByLastName(String last_name);
void remove(int AFM);
double getMeanSavings();
void printByAFM();
void printTopLargeDepositors(int k); 
}
