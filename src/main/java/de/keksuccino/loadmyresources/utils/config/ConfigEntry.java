package de.keksuccino.loadmyresources.utils.config;

import org.jetbrains.annotations.Nullable;

public class ConfigEntry {
   private String name;
   private String value;
   private String category;
   private String desc;
   private ConfigEntry.EntryType type;

   public ConfigEntry(String name, String value, ConfigEntry.EntryType type, String category, @Nullable String description) {
      this.name = name;
      this.value = value;
      this.type = type;
      this.category = category;
      this.desc = description;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public ConfigEntry.EntryType getType() {
      return this.type;
   }

   public String getCategory() {
      return this.category;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public void setDescription(String description) {
      this.desc = description;
   }

   public String getDescription() {
      return this.desc;
   }

   public static enum EntryType {
      INTEGER,
      STRING,
      DOUBLE,
      LONG,
      FLOAT,
      BOOLEAN;

      // $FF: synthetic method
      private static ConfigEntry.EntryType[] $values() {
         return new ConfigEntry.EntryType[]{INTEGER, STRING, DOUBLE, LONG, FLOAT, BOOLEAN};
      }
   }
}
