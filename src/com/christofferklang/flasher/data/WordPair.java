package com.christofferklang.flasher.data;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

public class WordPair {
  public static final String FIELD_ID = "id";
  public static final String FIELD_QUESTION_TEXT = "question_text";
  public static final String FIELD_ANSWER_TEXT = "answer_text";
  public static final String FIELD_PRIMARY_GROUP = "primary_group";
  public static final String FIELD_SECONDARY_GROUP = "secondary_group";

  @DatabaseField(
    columnName = FIELD_ID,
    generatedId = true
  )
  int id;

  @DatabaseField(
    columnName = FIELD_QUESTION_TEXT,
    canBeNull = false,
    dataType = DataType.STRING
  )
 String questionText;

  @DatabaseField(
    columnName = FIELD_ANSWER_TEXT,
    canBeNull = false,
    dataType = DataType.STRING
  )
  String answerText;

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
