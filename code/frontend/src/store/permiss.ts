import { defineStore } from 'pinia';

interface ObjectList {
	[key: string]: string[];
}

export const usePermissStore = defineStore('permiss', {
	state: () => {
		const keys = localStorage.getItem('ms_keys');
		return {
			key: keys ? JSON.parse(keys) : <string[]>[],
			defaultList: <ObjectList>{
				manager: ['1', '2', '3', '4', '5', '6', '7'],
				faculty: ['1', '2', '4', '7'],
				technologist: ['1', '2', '4', '6','7'],
			}
		};
	},
	actions: {
		handleSet(val: string[]) {
			this.key = val;
		}
	}
});
