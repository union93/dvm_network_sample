package DVM_Server;

import javafx.collections.ListChangeListener;


public interface messageListChangeListner extends ListChangeListener<String> {
     void onChanged(Change<? extends String> change);
}
