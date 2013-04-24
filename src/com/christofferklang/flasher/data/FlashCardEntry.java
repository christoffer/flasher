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

  // Language classification
  public static final String FIELD_LANG_CODE = "en";

  // Additional entry classification
  public static final String FIELD_PRIMARY_GROUP = "primary_group";
  public static final String FIELD_SECONDARY_GROUP = "secondary_group";

  // Non-value
  public static final int NONE = 0;

  // Language identifiers
  public static final int ENGLISH = 1;
  public static final int GERMAN = 2;

  // Common classification constants
  public static final int NOUN = 1;
  public static final int VERB = 2;
  public static final int ADJECTIVE = 3;

  // German language genders
  public static final int MASCULINE = 4;
  public static final int NEUTER = 5;
  public static final int FEMININE = 6;

  @DatabaseField(
    columnName = FIELD_ID,
    generatedId = true
  )
  private int id;

  @DatabaseField(
    columnName = FIELD_TEXT,
    canBeNull = false,
    dataType = DataType.STRING
  )
  private String mText;

  @DatabaseField(
    columnName = FIELD_LANG_CODE,
    dataType = DataType.SHORT
  )
  private int mLanguageCode;

  @DatabaseField(
    columnName = FIELD_PRIMARY_GROUP,
    dataType = DataType.SHORT
  )
  private int mPrimaryGroup;

  @DatabaseField(
    columnName = FIELD_SECONDARY_GROUP,
    dataType = DataType.SHORT
  )
  private int mSecondaryGroup;

  @SuppressWarnings("UnusedDeclaration")
  public FlashCardEntry() {
    this("", NONE, NONE);
  }

  @SuppressWarnings("UnusedDeclaration")
  public FlashCardEntry(String text) {
    this(text, NONE, NONE);
  }

  @SuppressWarnings("UnusedDeclaration")
  public FlashCardEntry(String text, int primaryGroup) {
    this(text, primaryGroup, NONE);
  }

  @SuppressWarnings("UnusedDeclaration")
  public FlashCardEntry(String text, int languageCode, int primaryGroup) {
    mText = text;
    mLanguageCode = languageCode;
    mPrimaryGroup = primaryGroup;
  }

  @SuppressWarnings("UnusedDeclaration")
  public FlashCardEntry(String text, int languageCode, int primaryGroup, int secondaryGroup) {
    mText = text;
    mLanguageCode = languageCode;
    mPrimaryGroup = primaryGroup;
    mSecondaryGroup = secondaryGroup;
  }

  public String getText() {
    return mText == null ? "" : mText;
  }

  public int getLanguageCode() {
    return mLanguageCode;
  }

  public int getPrimaryGroup() {
    return mPrimaryGroup;
  }

  public int getSecondaryGroup() {
    return mSecondaryGroup;
  }
}
