package io.philpott.vueflip.vueflip;

import com.intellij.ide.actions.OpenFileAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.impl.OpenEditorInOppositeTabGroupAction;
import com.intellij.openapi.vfs.VirtualFile;

public class VueFlip extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Document document = e.getData(LangDataKeys.EDITOR).getDocument();
        VirtualFile file = FileDocumentManager.getInstance().getFile(document);

        String path = file.getPath();
        String newPath = null;
        if (path.endsWith(".ts")) {
            newPath = path.substring(0, path.length() - 2);
            newPath += "html";
        }

        if (path.endsWith(".html")) {
            newPath = path.substring(0, path.length() - 4);
            newPath += "ts";
        }

        if (newPath != null) {
            OpenFileAction.openFile(newPath, e.getProject());
            OpenEditorInOppositeTabGroupAction.getEventProject(e).
        }
    }
}
