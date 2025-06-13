package med.voll.api.person;

public enum Gender {

   F("FEMALE"),
   M("MALE"),
   NB("NONBINARY"),
   O("OTHER");

   private final String label;

   Gender(String label) {
      this.label = label;
   }

   public String getLabel() {
      return label;
   }

   public static Gender fromLabel(String label) {
      for (Gender gender : Gender.values()) {
         if (gender.label == label) {
            return gender;
         }
      }
      throw new IllegalArgumentException("Invalid gender code: " + label);
   }
}
