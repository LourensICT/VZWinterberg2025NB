import Dexie, { type Table } from 'dexie'
import type { Note } from './types'

export class NotesDatabase extends Dexie {
  notes!: Table<Note, string>

  constructor() {
    super('vzwinterberg2025-notebook')
    this.version(1).stores({
      notes: 'id, createdAt, kind'
    })
  }
}

export const db = new NotesDatabase()

export async function addNote(note: Note) {
  await db.notes.add(note)
}

export async function getAllNotes(): Promise<Note[]> {
  return db.notes.orderBy('createdAt').reverse().toArray()
}

export async function clearAllNotes() {
  await db.notes.clear()
}