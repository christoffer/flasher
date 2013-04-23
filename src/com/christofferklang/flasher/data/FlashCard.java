package com.christofferklang.flasher.data;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import static com.christofferklang.flasher.data.FlashCard.FIELD_ANSWER_ID;
import static com.christofferklang.flasher.data.FlashCard.FIELD_ID;
import static com.christofferklang.flasher.data.FlashCard.FIELD_QUESTION_ID;

/**
 * A flash card is an association between two flash card entries.
 *
 * One of the entries is set to be the question and one to be the answer.
 */
@DatabaseTable(tableName = "flashcards")
public class FlashCard {

  // Database id
  public static final String FIELD_ID = "id";

  // Id of the question flash card entry
  public static final String FIELD_QUESTION_ID = "question_id";

  // Id of the answer flash card entry
  public static final String FIELD_ANSWER_ID = "answer_id";

  @DatabaseField(
    columnName = FIELD_ID,
    generatedId = true
  )
  public int id;

  @DatabaseField(
    columnName = FIELD_QUESTION_ID,
    canBeNull = false,
    foreign = true
  )
  public FlashCardEntry questionEntry;

  @DatabaseField(
    columnName = FIELD_ANSWER_ID,
    canBeNull = false,
    foreign = true
  )
  public FlashCardEntry answerEntry;
}
