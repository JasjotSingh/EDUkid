package bu.edu.cs673.edukid.db.model.category;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import bu.edu.cs673.edukid.R;
import bu.edu.cs673.edukid.db.Database;
import bu.edu.cs673.edukid.db.DatabaseDefaults;
import bu.edu.cs673.edukid.db.model.Colour;

@SuppressWarnings("serial")
public class ColorsCategory implements CategoryType {

	@Override
	public String getCategoryName() {
		return "Colors";
	}

	@Override
	public Drawable getCategoryImage(Context context) {
		return context.getResources().getDrawable(R.drawable.colorsnew);
	}

	@Override
	public String[] getItems() {
		// TODO: don't hardcode
		return DatabaseDefaults.getColours();
	}

	@Override
	public String getItem(int itemIndex) {
		// TODO
		return DatabaseDefaults.getColours()[itemIndex];
	}

	@Override
	public int getItemCount() {
		return DatabaseDefaults.getColours().length;
	}

	@Override
	public String getItemPhoneticSound(int itemIndex) {
		// TODO
		Colour col = Database.getInstance().getColours().get(itemIndex);

		if (col != null) {
			String colourSound = col.getColourSound();

			if (colourSound != null && !colourSound.isEmpty()) {
				return colourSound;
			}
		}

		return DatabaseDefaults.getDefaultColourPhoneticSounds(itemIndex);
	}

	@Override
	public List<String> getItemWords(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultColourWords(itemIndex);
	}

	@Override
	public String getItemWord(int itemIndex, int wordIndex) {
		// TODO
		return DatabaseDefaults.getDefaultColourWords(itemIndex).get(
				wordIndex);
	}

	@Override
	public int getItemWordCount(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultColourWords(itemIndex).size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> getItemImages(int itemIndex) {
		// TODO
		return DatabaseDefaults.getDefaultColourDrawableIds(itemIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemImage(int itemIndex, int imageIndex) {
		// TODO
		return getItemImages(itemIndex).get(imageIndex);
	}

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
	public boolean canDeleteCategory() {
		return false;
	}
}
