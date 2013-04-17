package com.christofferklang.FlashCards.data;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class WordPair {
  public static final String FIELD_ID = "id";
  public static final String FIELD_FROM_TEXT = "from_text";
  public static final String FIELD_TO_TEXT = "to_text";
  public static final String FIELD_PRIMARY_GROUP = "primary_group";
  public static final String FIELD_SECONDARY_GROUP = "secondary_group";

  @DatabaseField(
    columnName = FIELD_ID,
    generatedId = true
  )
  int id;

  @DatabaseField(
    columnName = FIELD_FROM_TEXT,
    canBeNull = false,
    dataType = DataType.STRING
  )
  String fromText;

  @DatabaseField(
    columnName = FIELD_TO_TEXT,
    canBeNull = false,
    dataType = DataType.STRING
  )
  String toText;

  @DatabaseField(
    columnName = FIELD_PRIMARY_GROUP,
    canBeNull = true,
    dataType = DataType.SHORT
  )
  int primaryGroup;

  @DatabaseField(
    columnName = FIELD_SECONDARY_GROUP,
    canBeNull = true,
    dataType = DataType.SHORT
  )
  int secondaryGroup;
}
