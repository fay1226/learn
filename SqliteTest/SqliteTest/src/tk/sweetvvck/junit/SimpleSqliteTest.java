package tk.sweetvvck.junit;

import java.util.List;

import tk.sweetvvck.constant.Constant;
import tk.sweetvvck.doman.Person;
import tk.sweetvvck.service.DbHelper;
import tk.sweetvvck.service.SimplePersonService;
import android.test.AndroidTestCase;
import android.util.Log;

public class SimpleSqliteTest extends AndroidTestCase {
	public void testDbHelper() {
		DbHelper db = new DbHelper(getContext(), "first", null, 2);
		db.getWritableDatabase();
	}

	public void testSave() {
		SimplePersonService personService = new SimplePersonService(getContext());
		for (int i = 0; i < 20; i++) {
			personService.save(new Person("simple", "123456"));
		}
	}

	public void testdelete() {
		SimplePersonService personService = new SimplePersonService(getContext());
		personService.delete(1);
	}

	public void testUpdate() {
		SimplePersonService personService = new SimplePersonService(getContext());
		Person person = personService.findById(2);
		person.setPhone("456");
		personService.update(person);
	}

	public void testFind() {
		SimplePersonService personService = new SimplePersonService(getContext());
		Person person = personService.findById(2);
		Log.i(Constant.TAG_SQLITETEST,
				person.getName() + "," + person.getPhone());
	}

	public void testGetScroll() {
		SimplePersonService personService = new SimplePersonService(getContext());
		List<Person> persons = personService.getScrollAll(2, 20);
		for (Person person : persons) {
			Log.i(Constant.TAG_SQLITETEST, person.toString());
		}
	}

	public void testGetCount() {
		SimplePersonService personService = new SimplePersonService(getContext());
		Log.i(Constant.TAG_SQLITETEST, personService.getCount() + "");
	}
}
