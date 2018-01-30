package tk.sweetvvck.junit;

import java.util.List;

import tk.sweetvvck.constant.Constant;
import tk.sweetvvck.doman.Person;
import tk.sweetvvck.service.DbHelper;
import tk.sweetvvck.service.PersonService;
import android.test.AndroidTestCase;
import android.util.Log;

public class SqliteTest extends AndroidTestCase {
	public void testDbHelper() {
		DbHelper db = new DbHelper(getContext(), "first", null, 2);
		db.getWritableDatabase();
	}

	public void testSave() {
		PersonService personService = new PersonService(getContext());
		for (int i = 0; i < 50; i++)
			personService.save(new Person("ck", "123"));
	}

	public void testdelete() {
		PersonService personService = new PersonService(getContext());
		personService.delete(51);
	}

	public void testUpdate() {
		PersonService personService = new PersonService(getContext());
		Person person = personService.findById(1);
		person.setPhone("456");
		personService.update(person);
	}

	public void testFind() {
		PersonService personService = new PersonService(getContext());
		Person person = personService.findById(1);
		Log.i(Constant.TAG_SQLITETEST,
				person.getName() + "," + person.getPhone());
	}

	public void testGetScroll() {
		PersonService personService = new PersonService(getContext());
		List<Person> persons = personService.getScrollAll(20, 20);
		for (Person person : persons) {
			Log.i(Constant.TAG_SQLITETEST, person.toString());
		}
	}

	public void testGetCount() {
		PersonService personService = new PersonService(getContext());
		Log.i(Constant.TAG_SQLITETEST, personService.getCount() + "");
	}
}
