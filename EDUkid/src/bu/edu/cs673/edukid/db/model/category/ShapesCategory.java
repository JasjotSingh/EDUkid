package bu.edu.cs673.edukid.db.model.category;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseHelper;
import bu.edu.cs673.edukid.db.defaults.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Shape;
import bu.edu.cs673.edukid.db.model.Word;

@SuppressWarnings("serial")
public class ShapesCategory implements CategoryType {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCategoryName() {
		return "Shapes";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCategoryId() {
		return Category.SHAPES.ordinal();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.shapes_selector);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(String item) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getItems() {
		return DatabaseDefaults.getShapes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItem(int itemIndex) {
		return DatabaseDefaults.getShapes()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		return DatabaseDefaults.getShapes().length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getItemPhoneticSound(int itemIndex) {
		Shape shape = Database.getInstance().getShapes().get(itemIndex);

		if (shape != null) {
			String ShapeSound = shape.getShapeSound();

			if (ShapeSound != null && !ShapeSound.isEmpty()) {
				return ShapeSound;
			}
		}

		return DatabaseDefaults.getDefaultShapePhoneticSounds()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDefaultWordCount(int itemIndex) {
		return DatabaseDefaults.getDefaultShapeWords()[itemIndex].length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getSettingsItemWords(int itemIndex) {
		return DatabaseDefaults.getDefaultShapeWords()[itemIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getSettingsItemWord(int itemIndex, int wordIndex) {
		return DatabaseDefaults.getDefaultShapeWords()[itemIndex][wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word[] getLearnItemWords(int itemIndex) {
		return getSettingsItemWords(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Word getLearnItemWord(int itemIndex, int wordIndex) {
		return getLearnItemWords(itemIndex)[wordIndex];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLearnItemWordCount(int itemIndex) {
		return DatabaseDefaults.getDefaultShapeWords()[itemIndex].length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSettingsItemDrawableId(int itemIndex, int imageIndex) {
		return DatabaseDefaults.getDefaultShapeWords()[itemIndex][imageIndex]
				.getDrawableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getSettingsItemDrawable(int itemIndex, int imageIndex) {
		List<Drawable> drawableList = new ArrayList<Drawable>();

		List<Word> databaseWords = Database.getInstance().getWords(
				DatabaseHelper.generateWordsSelection(itemIndex));

		if (databaseWords.size() > 0) {
			for (Word databaseWord : databaseWords) {
				drawableList.add(databaseWord.getWordDrawable());
			}
		}

		return drawableList.get(imageIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLearnItemDrawableId(int itemIndex, int imageIndex) {
		return getLearnItemWords(itemIndex)[imageIndex].getDrawableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Drawable getLearnItemDrawable(int itemIndex, int imageIndex) {
		return getLearnItemWords(itemIndex)[imageIndex].getWordDrawable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItemWord(int itemIndex, Word word) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void editItemWord(int itemIndex, int wordIndex, Word word) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteItemWord(int itemIndex, int wordIndex) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemTextSize() {
		return 50;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canAddItems() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasGameMode() {
		return false;
	}
}
