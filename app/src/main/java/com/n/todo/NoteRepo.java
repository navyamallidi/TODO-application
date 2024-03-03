package com.n.todo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepo {
    private NotesDoa notesDoa;
    private LiveData<List<Note>> notelist;

    public NoteRepo(Application application)
    {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        notesDoa = noteDatabase.notesDoa();
        notelist = notesDoa.getAllDate();

    }
    public void insertData(Note note){new InsertTask(notesDoa).execute(note);}
    public void deleteData(Note note){new DeleteTask(notesDoa).execute(note);}
    public void updateData(Note note){new UpdateTask(notesDoa).execute(note);}
    public LiveData<List<Note>> getAllData(){
        return notelist;
    }

    public static class InsertTask extends AsyncTask<Note,Void,Void>{

        private NotesDoa notesDoa;

        public InsertTask (NotesDoa notesDoa){
            this.notesDoa = notesDoa;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            notesDoa.insert(notes[0]);
            return null;
        }


    }
    public static class DeleteTask extends AsyncTask<Note,Void,Void>{

        private NotesDoa notesDoa;

        public DeleteTask (NotesDoa notesDoa){
            this.notesDoa = notesDoa;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            notesDoa.delete(notes[0]);
            return null;
        }


    }
    public static class UpdateTask extends AsyncTask<Note,Void,Void>{

        private NotesDoa notesDoa;

        public UpdateTask (NotesDoa notesDoa){
            this.notesDoa = notesDoa;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            notesDoa.update(notes[0]);
            return null;
        }


    }

}
