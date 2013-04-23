package com.christofferklang.flasher.data;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Atomical entry of a flash card.
 *
 * This is the word or phrase along with some additional classification
 * that will appear on either the question or the answer side of a flash card
 */
@DatabaseTable(tableName = "flashcard_entries")
public class FlashCardEntry {

  // Database id
  public static final String FIELD_ID = "id";

  // Text of the entry
  public static final String FIELD_TEXT = "text";

  // Additional entry classification
  public static final String FIELD_PRIMARY_GROUP = "primary_group";
  public static final String FIELD_SECONDARY_GROUP = "secondary_group";

  @DatabaseField(
    columnName = FIELD_ID,
    generatedId = true
  )
  public int id;

  @DatabaseField(
    columnName = FIELD_TEXT,
    canBeNull = false,
    dataType = DataType.STRING
  )
 public String text;

  @DatabaseField(
    columnName = FIELD_PRIMARY_GROUP,
    canBeNull = true,
    dataType = DataType.SHORT
  )
  public int primaryGroup;

  @DatabaseField(
    columnName = FIELD_SECONDARY_GROUP,
    canBeNull = true,
    dataType = DataType.SHORT
  )
  public int secondaryGroup;
}
